import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";

@Component({
  selector: 'app-post-question',
  templateUrl: './post-question.component.html',
  styleUrl: './post-question.component.scss'
})
export class PostQuestionComponent {

  constructor(
    private service: QuestionService
  ) {
  }

  ngOnInit(){}

  postQuestion() {

  }

}
