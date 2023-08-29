import { createSlice } from "@reduxjs/toolkit";

import { authService } from "../service";

export type UserInfoResponse = {
    id: number,
    username: string,
    enabled: boolean,
    accounts: any[]
}

type AuthSliceInitial = {
    user: UserInfoResponse,
    jwt_token: string,
    isAuth: boolean,
}

const initialState: AuthSliceInitial = {
    user: {
        id: 0,
        username: '',
        enabled: false,
        accounts: []
    },
    jwt_token: '',
    isAuth: false,
}

const auth = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        updateAuth: (state, action) => {
            const { accessToken } = action.payload;
            state.jwt_token = accessToken
            state.isAuth = true
        },
        updateUser: (state, action) => {
            const { data } = action.payload
            state.user = data
        }
    },
})

export const { updateAuth, updateUser } = auth.actions

export default auth.reducer;