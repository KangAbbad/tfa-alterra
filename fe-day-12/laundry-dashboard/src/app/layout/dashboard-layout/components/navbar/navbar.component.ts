import { Component, DoCheck, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { MegaMenuItem, MenuItem } from 'primeng/api';

@Component({
  selector: 'app-navbar-component',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit, DoCheck {
  breadcrumbHome!: MenuItem;
  breadcrumbItems: MenuItem[] = [];

  megaMenuItems: MegaMenuItem[] = [];

  constructor(private title: Title) {}

  ngOnInit(): void {
    this.breadcrumbHome = { label: 'Dashboard', routerLink: '/dashboard' };
    this.megaMenuItems = [
      {
        label: 'Videos',
        icon: 'pi pi-fw pi-video',
        items: [
          [
            {
              label: 'Video 1',
              items: [{ label: 'Video 1.1' }, { label: 'Video 1.2' }],
            },
            {
              label: 'Video 2',
              items: [{ label: 'Video 2.1' }, { label: 'Video 2.2' }],
            },
          ],
          [
            {
              label: 'Video 3',
              items: [{ label: 'Video 3.1' }, { label: 'Video 3.2' }],
            },
            {
              label: 'Video 4',
              items: [{ label: 'Video 4.1' }, { label: 'Video 4.2' }],
            },
          ],
        ],
      },
    ];
  }

  ngDoCheck(): void {
    this.breadcrumbItems = [{ label: this.title.getTitle(), disabled: true }];
  }
}
