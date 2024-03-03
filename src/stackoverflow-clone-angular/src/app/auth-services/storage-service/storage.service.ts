import {Injectable} from '@angular/core';

const TOKEN = 'c_token';
const USER = 'c_user';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() {
  }

  public saveUser(user: any) {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  static getUser(): any {
    return JSON.parse(localStorage.getItem(USER)!);
  }

  public saveToken(token: string) {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  static getToken(): string {
    return localStorage.getItem(TOKEN)!;
  }

  static isUserLoggedIn() {
    return this.getToken() != null;
  }

  static logout() {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.removeItem(USER);
  }

  static hasToken() {
    return this.getToken() !== null;
  }

  static getUserId(): string {
    const user = this.getUser();
    if (user == null) {
      return '';
    }
    return user.userId;
  }

  static getUserRole() {
    const user = this.getUser();
    if (user == null) {
      return '';
    }
    return user.role;
  }

  static isAdminLoggedIn() {
    if (this.getToken() === null) {
      return false;
    }
    const role: string = this.getUserRole();
    return role === '1';
  }
}
