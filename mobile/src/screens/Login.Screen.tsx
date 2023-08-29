import { useReducer } from 'react';
import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { Link } from '@react-navigation/native';
import { useDispatch } from 'react-redux';

import { useLoginMutation } from '../api/service/auth.service';
import { updateAuth } from '../api/slice/auth.slice';
import { Input } from '../components';


const LoginScreen = ({ navigation }) => {

    const dispatchRedux = useDispatch();
    const [login] = useLoginMutation();
    const [loginData, dispatch] = useReducer(handleReducer, { username: '', password: '' })

    function handleReducer(state, action) {
        switch(action.type) {
            case 'add_username': {
                return { username: action.username, password: state.password }
            }
            case 'add_password': {
                return { username: state.username, password: action.password }
            }
        }
    }

    async function handleClick() {
        const { username, password } = loginData
        if (username && password) {
            const response = await login(loginData)
            console.log(response);
            if (response) {
                const { data } = response
                const { accessToken } = data
                dispatchRedux(updateAuth({ accessToken }))
                await AsyncStorage.setItem('auth', JSON.stringify({ token: accessToken, isAuth: true }))
                navigation.navigate('Main')
            }
        }
    }

    return (
        <SafeAreaView style={styles.container}>
            <Text style={styles.text}>Log In</Text>
            <View style={styles.form}>
                <Input 
                    placeholder='Username'
                    value={loginData.username}
                    onChange={({nativeEvent: {text}}) => dispatch({type:'add_username', username: text})}
                    inputMode='email'
                    keyboardType='email-address'
                />
                <Input 
                    placeholder='Password'
                    value={loginData.password}
                    onChange={({nativeEvent: {text}}) => dispatch({type:'add_password', password: text})}
                    secureTextEntry={true}
                />
            </View>
            <TouchableOpacity style={styles.button} onPress={() => handleClick()}>
                <Text style={styles.button__text}>Log In</Text>
            </TouchableOpacity>
            <Text style={styles.text_bottom}>
                Don’t have an account? 
                <Link to={'/Register'}> Sign In</Link>
            </Text>
        </SafeAreaView>
    )
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingHorizontal: 16,
        paddingTop: 60,
        backgroundColor: '#FFFFFF'
    },
    form: {
        marginTop: 32,
        gap: 15,
        paddingBottom: 160,
    },
    text: {
        fontSize: 30,
        color: '#000',
        textAlign: 'center',
        fontWeight: '600',
        fontFamily: 'Inter'
    },
    button: {
        paddingVertical: 16,
        borderRadius: 100,
        backgroundColor: '#5DB097'
    },
    button__text: {
        color: '#fff',
        fontSize: 16,
        fontWeight: '600',
        textAlign: 'center'
    },
    text_bottom: {
        fontSize: 16,
        color: '#5DB097',
        textAlign: 'center',
        marginTop: 20,
    }
})

export default LoginScreen;