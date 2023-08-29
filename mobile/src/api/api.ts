import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

import { RootState } from './store';

const BASE_URL = 'http://10.0.2.2:8888/'

const baseQuery = fetchBaseQuery({
    baseUrl: BASE_URL,
    prepareHeaders: (headers, { getState }) => {
        const token = (getState() as RootState).authSlice.jwt_token;
        if (token) {
            headers.set('Authorization', `Bearer ${token}`)
          }
        return headers
    }
})

export const api = createApi({
    reducerPath: 'api',
    baseQuery: baseQuery,
    endpoints: () => ({})
})