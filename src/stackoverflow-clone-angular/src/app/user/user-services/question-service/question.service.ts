import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

const BASIC_URL = ['http://localhost:8080/'];

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private http: HttpClient
  ) { }
}
