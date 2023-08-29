import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
} from 'react-native';

import { Link } from '@react-navigation/native';

import { Input, CustomCheckBox } from '../components';

const RegisterScreen = () => {
    return (
        <SafeAreaView style={styles.container}>
            <Text style={styles.text}>Sign Up</Text>
            <View style={styles.form}>
                <Input 
                    placeholder='Name'
                />
                <Input 
                    placeholder='Email'
                    inputMode='email'
                    keyboardType='email-address'
                />
                <Input 
                    placeholder='Password'
                    secureTextEntry={true}
                />
                <View style={styles.confrim__container}>
                    <CustomCheckBox />
                    <Text>I would like to receive your newsletter.</Text>
                </View>
            </View>
            <TouchableOpacity style={styles.button}>
                <Text style={styles.button__text}>Sign Up</Text>
            </TouchableOpacity>
            <Text style={styles.text_bottom}>
                Already have an account?
                <Link to={'/Login'}> Sign In</Link>
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
        paddingBottom: 60,
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
    },
    confrim__container: {
        width: '100%',
        flexDirection: 'row',
        alignItems: 'center',
    }
})

export default RegisterScreen;