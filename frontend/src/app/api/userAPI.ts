import axios from "axios";
import { loginUrl } from "./routes";
import { Response } from "./Response";

export async function tryLogin(mail: string, password: string): Promise<Response> {
    const axiosResponse = await axios.post(loginUrl, {
        email: mail,
        password: password
    });
    return axiosResponse.data as Response;
} 