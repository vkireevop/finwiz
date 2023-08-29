import { api } from "../api";

export const authService = api.injectEndpoints({
    endpoints: (build) => ({
        signup: build.mutation({
            query: (user) => ({
                url: `/auth/signup`,
                method: 'POST',
                body: user,
            })
        }),
        login: build.mutation({
            query: (user) => ({
                url: `/auth/login`,
                method: 'POST',
                body: user,
            })
        }),
        user: build.query({
            query: () => ({
                url: `/user`,
            })
        }),
    })
})

export const { 
    useSignupMutation,
    useLoginMutation,
    useLazyUserQuery
} = authService
