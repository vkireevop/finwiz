import { createNativeStackNavigator } from "@react-navigation/native-stack";

import BottomNavigator from "./BottomNavigator";

import {
    RegisterScreen,
    LoginScreen,
    SendScreen,
    ReceiveScreen,
    SwapScreen,
    BuyScreen,
    AccountScreen
} from "../screens";

const Stack = createNativeStackNavigator()

const RootNavigator = () => {
    return (
        <Stack.Navigator
            initialRouteName='Register'
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
                <Stack.Screen 
                    name="Swap"
                    component={SwapScreen}
                    options={{
                        headerTransparent: true,
                    }}
                />
                <Stack.Screen 
                    name="Buy"
                    component={BuyScreen}
                    options={{
                        headerTransparent: true,
                    }}
                />
                <Stack.Screen 
                    name="Account"
                    component={AccountScreen}
                    options={{
                        headerTransparent: true,
                    }}
                />
    </Stack.Navigator>
    )
};

export default RootNavigator;