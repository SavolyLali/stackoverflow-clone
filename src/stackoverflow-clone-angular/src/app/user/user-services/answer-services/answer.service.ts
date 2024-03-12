import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StorageService} from "../../../auth-services/storage-service/storage.service";

const BASIC_URL = ['http://localhost:8080/'];

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  constructor(
    private http: HttpClient
  ) {
  }

  createAuthorizationHeader(): HttpHeaders {
    let authHeaders = new HttpHeaders();
    return authHeaders.set('Authorization', 'Bearer ' + StorageService.getToken());
  }
}
