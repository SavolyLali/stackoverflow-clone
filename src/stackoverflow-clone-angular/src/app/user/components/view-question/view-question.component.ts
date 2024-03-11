import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrl: './view-question.component.scss'
})
export class ViewQuestionComponent {

  questionId: number = this.activatedRoute.snapshot.params["questionId"];
  question: any;

  constructor(
    private questionService: QuestionService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.getQuestionById();
  }

  getQuestionById() {
    this.questionService.getQuestionById(this.questionId).subscribe(
      (response) => {
        console.log(response);
        this.question = response.questionDto;
      }
    );
  }
}
