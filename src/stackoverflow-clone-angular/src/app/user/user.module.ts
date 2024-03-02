import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule, FormsModule} from "@angular/forms";
import {UserRoutingModule} from './user-routing.module';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {PostQuestionComponent} from './components/post-question/post-question.component';


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
    FormsModule
  ]
})
export class UserModule {
}
