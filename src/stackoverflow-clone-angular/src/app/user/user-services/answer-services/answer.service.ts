import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StorageService} from "../../../auth-services/storage-service/storage.service";
import {Observable} from "rxjs";

const BASIC_URL = ['http://localhost:8080/'];

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  constructor(
    private http: HttpClient
  ) {
  }

  postAnswer(answerDto: any): Observable<any> {
    answerDto.userId = StorageService.getUserId();
    console.log(answerDto);
    return this.http.post<[]>(BASIC_URL + 'api/answer', answerDto,
      {headers: this.createAuthorizationHeader()});
  }

  createAuthorizationHeader(): HttpHeaders {
    let authHeaders = new HttpHeaders();
    return authHeaders.set('Authorization', 'Bearer ' + StorageService.getToken());
  }
}
