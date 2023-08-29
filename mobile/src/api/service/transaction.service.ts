import { api } from "../api";

export const transactionService = api.injectEndpoints({
    endpoints: (build) => ({
        createAccount: build.mutation({
            query: (user) => ({
                url: `/account/create`,
                method: 'POST',
                body: user,
            })
        }),
        banks: build.query({
            query: () => ({
                url: `/banks/all`,
            })
        }),
        getAccounts: build.query({
            query: () => ({
                url: `/account/all`,
            })
        }),
    })
})

export const {
    useCreateAccountMutation,
    useBanksQuery,
    useLazyGetAccountsQuery,
} = transactionService
