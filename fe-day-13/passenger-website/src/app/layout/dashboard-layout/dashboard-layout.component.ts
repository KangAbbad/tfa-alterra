import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SessionService } from 'src/app/services/session/session.service';
import { IUserInfo } from 'src/app/models/IAuth';

@Component({
  selector: 'app-dashboard-layout',
  templateUrl: './dashboard-layout.component.html',
  styleUrls: ['./dashboard-layout.component.scss']
})
export class DashboardLayoutComponent implements OnInit {
  constructor(private sessionService: SessionService, private router: Router) { }

  ngOnInit(): void {
  }

  getUserInfo(): IUserInfo {
    return this.sessionService.getSession() ?? { email: '' };
  }

  onLogout(): void {
    this.sessionService.destroySession();
    this.router.navigateByUrl('/auth/login');
  }
}
