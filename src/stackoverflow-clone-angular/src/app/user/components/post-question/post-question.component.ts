import {Component, inject} from '@angular/core';
import {QuestionService} from "../../user-services/question-service/question.service";
import {COMMA, ENTER} from "@angular/cdk/keycodes";
import {LiveAnnouncer} from "@angular/cdk/a11y";
import {MatChipEditedEvent, MatChipInputEvent} from "@angular/material/chips";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-post-question',
  templateUrl: './post-question.component.html',
  styleUrl: './post-question.component.scss'
})
export class PostQuestionComponent {

  tags = [];
  isSubmitting!: boolean;
  addOnBlur = true;
  validateForm!: FormGroup;

  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  announcer = inject(LiveAnnouncer);

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    // Add our fruit
    if (value) {
      this.tags.push({name: value});
    }
    // Clear the input value
    event.chipInput!.clear();
  }

  remove(tag: any): void {
    const index = this.tags.indexOf(tag);
    if (index >= 0) {
      this.tags.splice(index, 1);
      this.announcer.announce(`Removed ${tag}`);
    }
  }

  edit(tag: any, event: MatChipEditedEvent) {
    const value = event.value.trim();
    // Remove tag if it no longer has a name
    if (!value) {
      this.remove(tag);
      return;
    }
    // Edit existing tag
    const index = this.tags.indexOf(tag);
    if (index >= 0) {
      this.tags[index].name = value;
    }
  }

  constructor(
    private service: QuestionService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.validateForm = this.fb.group({
      title: ['', Validators.required],
      body: ['', Validators.required],
      tags: ['', Validators.required]
    });
  }

  postQuestion() {

  }

}
