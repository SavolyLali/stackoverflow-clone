import {Component} from '@angular/core';
import {AuthService} from "../../auth-services/auth-service/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  signupForm: FormGroup = new FormGroup({});

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private router: Router
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
    this.service.signup(this.signupForm.value).subscribe((response) => {
      console.log(response);
      if (response.id !== null) {
        this.snackBar.open(
          'You have successfully registered!',
          'Close',
          {duration: 5000}
        );
        this.router.navigateByUrl('/login');
      } else {
        this.snackBar.open(
          response.message,
          'Close',
          {duration: 5000}
        );
      }
    }, (error: any) => {
      this.snackBar.open(
        'Registration failed. Please try again later',
        'Close',
        {duration: 5000}
      )
    })
  }

}
