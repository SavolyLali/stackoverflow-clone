import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {map, Observable, tap} from "rxjs";
import {StorageService} from "../storage-service/storage.service";


const BASIC_URL = ['http://localhost:8080/']
const AUTH_HEADER = 'Authorization';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private storage: StorageService
  ) {
  }

  signup(signupRequest: any): Observable<any> {
    return this.http.post(BASIC_URL + 'sign-up', signupRequest);
  }

  login(loginRequest: any): Observable<any> {
    return this.http.post(BASIC_URL + 'authentication', loginRequest,
      {observe: 'response'})
      .pipe(
        tap(__ => this.log("User Authentication")),
        map((res: HttpResponse<any>) => {
          this.storage.saveUser(res.body);
          const authHeader = res.headers.get(AUTH_HEADER);
          if (authHeader) {
            const tokenLength = authHeader.length;
            const bearerToken = authHeader.substring(7, tokenLength);
            this.storage.saveToken(bearerToken);
          }
          return res;
        })
      );
  }

  log(message: string) {
    console.log("User Auth Service" + message);
  }
}
