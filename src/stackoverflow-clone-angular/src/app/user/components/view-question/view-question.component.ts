import {Component} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StorageService} from "../../../auth-services/storage-service/storage.service";
import {AnswerService} from "../../user-services/answer-services/answer.service";

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
    private answerService: AnswerService,
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
    const data = this.validateForm.value;
    data.questionId = this.questionId;
    data.userId = StorageService.getUserId();
    console.log(data);
    this.answerService.postAnswer(data).subscribe(
      (response) => {
        console.log(response);
      }
    );
  }
}
