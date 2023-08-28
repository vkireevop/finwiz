import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Icon from 'react-native-vector-icons/FontAwesome'; 

import {
    HomeScreen,
    CurrencyScreen
} from '../screens';


const Tab = createBottomTabNavigator();

const BottomNavigator = () => {
  return (
    <Tab.Navigator
        initialRouteName='Home'
    >
        <Tab.Screen
            name="Home" 
            component={HomeScreen}
            options={{
                tabBarShowLabel: false,
                headerShown: false,
                tabBarIcon: ({ focused }) => (
                    focused 
                        ? <Icon name='home' color='#4B947E' size={24} /> 
                        : <Icon name='home' color='#000' size={24} />
                )
            }}
        />
        <Tab.Screen
            name="Currency" 
            component={CurrencyScreen}
            options={{
                tabBarShowLabel: false,
                headerShown: false,
                tabBarIcon: ({ focused }) => (
                    focused 
                        ? <Icon name='credit-card' color='#4B947E' size={18} /> 
                        : <Icon name='credit-card' color='#000' size={18} />
                )
            }}
        />
        <Tab.Screen
            name="Settings" 
            component={HomeScreen}
            options={{
                tabBarShowLabel: false,
                headerShown: false,
                tabBarIcon: ({ focused }) => (
                    focused 
                        ? <Icon name='gear' color='#4B947E' size={24} /> 
                        : <Icon name='gear' color='#000' size={24} />
                )
            }}
        />
    </Tab.Navigator>
  );
}

export default BottomNavigator;