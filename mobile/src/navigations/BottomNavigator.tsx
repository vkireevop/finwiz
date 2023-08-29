import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useSelector } from 'react-redux';
import { useEffect } from 'react';

import { RootState } from '../api/store';
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
                        ? <Icon name='gear' color='#4B947E' size={18} /> 
                        : <Icon name='gear' color='#000' size={18} />
                )
            }}
        />
    </Tab.Navigator>
  );
}

export default BottomNavigator;