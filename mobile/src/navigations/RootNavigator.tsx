import { createNativeStackNavigator } from "@react-navigation/native-stack";

import BottomNavigator from "./BottomNavigator";

import {
    RegisterScreen,
    LoginScreen,
    SendScreen,
    ReceiveScreen,
} from "../screens";

const Stack = createNativeStackNavigator()

const RootNavigator = () => (
    <Stack.Navigator
        initialRouteName="Main"
    >
        <Stack.Screen 
            name="Register"
            component={RegisterScreen}
            options={{
                headerShown: false
            }}
        />
        <Stack.Screen 
            name="Login"
            component={LoginScreen}
            options={{
                headerShown: false
            }}
        />
        <Stack.Screen 
            name="Main"
            component={BottomNavigator}
            options={{
                headerShown: false
            }}
        />
        <Stack.Screen 
            name="Send"
            component={SendScreen}
            options={{
                headerTransparent: true,
            }}
        />
        <Stack.Screen 
            name="Receive"
            component={ReceiveScreen}
            options={{
                headerTransparent: true,
            }}
        />
    </Stack.Navigator>
);

export default RootNavigator;