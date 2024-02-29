import {Component} from '@angular/core';
import {AuthService} from "../../auth-services/auth-service/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  signupForm: FormGroup = new FormGroup({});

  constructor(
    private service: AuthService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.signupForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    }, {validator: this.confirmValidator});
  }

  private confirmValidator(fg: FormGroup) {
    const password = fg.get('password')?.value;
    const confirmPassword = fg.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      fg.get('confirmPassword')?.setErrors({passwordMismatch: true});
    } else {
      fg.get('confirmPassword')?.setErrors(null);
    }
  }


  signup() {
    console.log(this.signupForm.value);
  }

}
