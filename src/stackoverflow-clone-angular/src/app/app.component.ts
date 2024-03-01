import {Component} from '@angular/core';
import {StorageService} from "./auth-services/storage-service/storage.service";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'stackoverflow-clone-angular';

  isUserLoggedIn!: boolean;

  constructor(
    private router: Router
  ) {
  }

  ngOnInit() {
    this.updateUserLoginStatus();
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.updateUserLoginStatus();
      }
    });
  }

  private updateUserLoginStatus() {
    this.isUserLoggedIn = StorageService.isUserLoggedIn();
  }

  logout() {
    StorageService.logout();
    this.router.navigateByUrl('/login');
  }
}
