import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {StorageService} from "../../../auth-services/storage-service/storage.service";

const BASIC_URL = ['http://localhost:8080/'];

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private http: HttpClient
  ) {
  }

  postQuestion(questionDto: any): Observable<any> {
    questionDto.userId = StorageService.getUserId();
    console.log(questionDto);
    return this.http.post<[]>(BASIC_URL + 'api/question', questionDto,
      {headers: this.createAuthorizationHeader()});
  }

  getAllQuestions(pageNumber: number): Observable<any> {
    return this.http.get<[]>(BASIC_URL + `api/questions/${pageNumber}`,
      {headers: this.createAuthorizationHeader()}
    );
  }

  getQuestionById(questionId: number): Observable<any> {
    return this.http.get<[]>(BASIC_URL + `api/question/${questionId}`,
      {headers: this.createAuthorizationHeader()}
    );
  }

  createAuthorizationHeader(): HttpHeaders {
    let authHeaders = new HttpHeaders();
    return authHeaders.set('Authorization', 'Bearer ' + StorageService.getToken());
  }
}
