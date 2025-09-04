import { inject } from "@angular/core";
import { Router, CanActivateFn } from "@angular/router";

export const authGuard: CanActivateFn = (route, state) => {
    const router = inject(Router);
    const isLoggedIn = !!localStorage.getItem('user');
    console.log('[authGuard] isLoggedIn=', isLoggedIn, 'url=', state?.url);
    if (!isLoggedIn) {
        return router.parseUrl('/login');
    }
    return true;
}