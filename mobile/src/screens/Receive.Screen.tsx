import { useState } from 'react';
import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
} from 'react-native';

import QRCode from 'react-native-qrcode-svg';
import { SelectList } from 'react-native-dropdown-select-list'

import { Input } from '../components';

const ReceiveScreen = () => {
    
    const [qr_value, setQr] = useState<string>('')
    const [selectedAccount, setSelectedAccount] = useState<string>('')
    const [amount, setAmount] = useState<string>('')

    const getQR = () => {
        const result = {
            amount: amount,
            account: selectedAccount,
        }
        setQr(JSON.stringify(result))
    }

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.form}>
                <Input 
                    placeholder='Amount'
                    keyboardType='numeric'
                    value={amount}
                    onChange={({nativeEvent: {text}}) => setAmount(text)}
                />
                <SelectList 
                    setSelected={(val: string) => setSelectedAccount(val)} 
                    data={[
                        {key: 1, value: '№43513432435'}
                    ]}
                    placeholder='Select Account'
                    save="value"
                    search={false}
                    boxStyles={
                        {
                            backgroundColor: '#F6F6F6',
                            borderColor:'#E8E8E8',
                            height: 50,
                        }
                    }
                />
            </View>
            <TouchableOpacity style={styles.button} onPress={() => getQR()}>
                <Text style={styles.button__text}>Get QR-Code</Text>
            </TouchableOpacity>
            {
                qr_value && (
                    <View style={styles.qr__container}>
                        <QRCode 
                            value={qr_value}
                            size={240}
                        />
                    </View>
                )
            }
        </SafeAreaView>
    )
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingHorizontal: 32,
        paddingTop: 48,
        backgroundColor: '#FFFFFF'
    },
    form: {
        marginTop: 32,
        gap: 15,
        paddingBottom: 15,
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
    radioButton: {
        borderRadius: 3,
        width: 25,
        height: 25,
        backgroundColor: '#F6F6F6',
        borderWidth: 1,
        borderColor: '#E8E8E8'
    },
    qr__container: {
        padding: 30,
        borderRadius: 30,
        backgroundColor: '#F6F6F6',
        alignSelf: 'center',
        marginTop: 50,
    }
})

export default ReceiveScreen;