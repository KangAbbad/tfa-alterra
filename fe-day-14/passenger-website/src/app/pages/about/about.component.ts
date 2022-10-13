import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartData } from 'chart.js';
import { UIChart } from 'primeng/chart';
import { concatMap, delay, of, Subscription } from 'rxjs';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';

import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
})
export class AboutComponent implements OnInit {
  @ViewChild("chart") chart!: UIChart;

  websocket$: WebSocketSubject<any> | undefined;
  subscription!: Subscription;
  basicData: ChartData = {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'Desember'],
    datasets: [
      {
        label: 'Bitcoin',
        data: [],
        fill: false,
        borderColor: '#42A5F5',
        tension: .4
      },
    ],
  };

  constructor() {}

  ngOnInit(): void {
    this.startWs();
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  startWs(): void {
    this.websocket$ = webSocket(environment.websocket_bitcoint);

    this.websocket$
      .pipe(
        concatMap((item) => of(item).pipe(delay(1000)))
      )
      .subscribe((res: any) => {
        const { data: chartData } = this.basicData.datasets[0];
        if (chartData.length === 12) {
          this.basicData.datasets[0].data.shift();
        }
        this.basicData.datasets[0].data.push(res.bitcoin);
        this.chart.refresh();
      });

    this.websocket$ = webSocket({
      url: environment.websocket_bitcoint,
      serializer: val => JSON.stringify({ channel: '', val })
    })
  }
}
