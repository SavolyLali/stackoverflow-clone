import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

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
    return this.http.post<[]>(BASIC_URL + 'api/question', questionDto);
  }
}
