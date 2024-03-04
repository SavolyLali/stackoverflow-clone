import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  constructor(
    private service: QuestionService
  ) {
  }

  ngOnInit() {
  }

  getAllQuestions(pageNumber: number) {
    this.service.getAllQuestions(pageNumber).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
