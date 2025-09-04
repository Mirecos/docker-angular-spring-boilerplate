import { Component } from '@angular/core';
import { tryLogin } from '../../api/userAPI';

@Component({
  selector: 'app-loginForm',
  imports: [NzFormModule],
  templateUrl: './loginForm.html'
})
export class Login {
  email: string = '';
  password: string = '';

  login() {
    tryLogin(this.email, this.password);
  }
}
