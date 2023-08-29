import {
    useSelector,
    useDispatch,
    TypedUseSelectorHook,
} from 'react-redux'

import { configureStore } from "@reduxjs/toolkit";

import { api } from './api';

import { authSlice } from './slice';

const store = configureStore({
    reducer: {
        [api.reducerPath]: api.reducer,
        authSlice
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({}).concat(api.middleware),
})


export type AppDispatch = typeof store.dispatch
export const useAppDispatch: () => AppDispatch = useDispatch
export type RootState = ReturnType<typeof store.getState>
export const useTypedSelector: TypedUseSelectorHook<RootState> = useSelector
export default store;