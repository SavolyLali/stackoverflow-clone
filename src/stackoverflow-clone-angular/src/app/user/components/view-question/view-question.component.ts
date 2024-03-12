import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrl: './view-question.component.scss'
})
export class ViewQuestionComponent {

  questionId: number = this.activatedRoute.snapshot.params["questionId"];
  question: any;
  validateForm!: FormGroup;

  constructor(
    private questionService: QuestionService,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.validateForm = this.fb.group({
      body: [null, Validators.required]
    })
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

  addAnswer() {
    console.log(this.validateForm.value)
  }
}
