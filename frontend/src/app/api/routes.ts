import { environment } from "../../environments/environment";

const apiUrl = environment.apiUrl;
export const baseUrl = apiUrl;
export const loginUrl = `${apiUrl}/login`;
export const registerUrl = `${apiUrl}/register`;


