import { Component } from '@angular/core';
import {AuthService} from "../../auth-services/auth-service/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  signupForm: FormGroup | undefined;

  constructor(
    private service: AuthService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.signupForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    });
  }


}
