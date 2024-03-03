import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule, FormsModule} from "@angular/forms";
import {UserRoutingModule} from './user-routing.module';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {PostQuestionComponent} from './components/post-question/post-question.component';
import {MatError, MatFormField} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";

///////////////////////
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';






@NgModule({
  declarations: [
    DashboardComponent,
    PostQuestionComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormField,
    MatError,
    MatButton,

    ///////
    MatProgressSpinnerModule,
    MatInputModule,
    MatFormFieldModule,
    MatChipsModule,
    MatIconModule
  ]
})
export class UserModule {
}
