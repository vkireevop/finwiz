import { useState } from 'react';
import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
    Alert,
} from 'react-native';

import QRCodeScanner from 'react-native-qrcode-scanner';
import { BarCodeReadEvent } from 'react-native-camera';
import { SelectList } from 'react-native-dropdown-select-list'

import { Input } from '../components';

const SendScreen = () => {
    const [selected, setSelected] = useState("");

    const [showScaner, setShowScaner] = useState<boolean>(false);

    const handleQrCode = (qr_data: BarCodeReadEvent) => {
        let { data } = qr_data
        data = JSON.parse(data)
        Alert.alert('New Qr-Code', data.account)
    }

    return (
        <SafeAreaView style={styles.container}>
            {
                showScaner && (
                    <View style={styles.qr_overlay__container}>
                        <QRCodeScanner
                            onRead={handleQrCode}
                            bottomContent={
                                <TouchableOpacity style={styles.buttonQrClose} onPress={() => setShowScaner(false)}>
                                    <Text style={styles.button__text}>Close</Text>
                                </TouchableOpacity>
                            }
                        />
                    </View>
                )
            }
            <View style={styles.form}>
                <Input 
                    placeholder='Recipient adress'
                />
                <Input 
                    placeholder='Amount'
                    keyboardType='numeric'
                />
                <SelectList 
                    setSelected={(val) => setSelected(val)} 
                    data={[]}
                    placeholder='Select Account'
                    save="value"
                    search={false}
                    maxHeight={6}
                    boxStyles={
                        {
                            backgroundColor: '#F6F6F6',
                            borderColor:'#E8E8E8',
                            height: 50,
                        }
                    }
                />
                <TouchableOpacity style={styles.button}>
                    <Text style={styles.button__text}>Send</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.button} onPress={() => setShowScaner(true)}>
                    <Text style={styles.button__text}>Scan Qr-Code</Text>
                </TouchableOpacity>
            </View>
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
    buttonQrClose: {
        paddingHorizontal: 70,
        paddingVertical: 16,
        borderRadius: 100,
        marginTop: 35,
        backgroundColor: '#5DB097'
    },
    button__text: {
        color: '#fff',
        fontSize: 16,
        fontWeight: '600',
        textAlign: 'center'
    },
    qr_overlay__container: {
        position: 'absolute',
        top: 0,
        bottom: 0,
        left: 0,
        right: 0,
        zIndex: 100,
        backgroundColor: 'rgba(0,0,0,.3)'
    }
})

export default SendScreen;