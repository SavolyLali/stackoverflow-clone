import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  questions: any[] = [];
  pageNum: number = 0;
  total!: number;

  constructor(
    private service: QuestionService
  ) {
  }

  ngOnInit() {
    this.getAllQuestions();
  }

  getAllQuestions() {
    this.service.getAllQuestions(this.pageNum).subscribe(
      (response) => {
        console.log(response);
        this.questions = response.questionDtoList;
        this.total = response.totalPages * 5;
      }
    );
  }

  pageIndexChange(event: any) {
    this.pageNum = event.pageIndex;
    this.getAllQuestions();
  }

}
