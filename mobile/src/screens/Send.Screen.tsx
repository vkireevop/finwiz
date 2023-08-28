import { useState } from 'react';
import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
} from 'react-native';
import { SelectList } from 'react-native-dropdown-select-list'

import { Input } from '../components';

const SendScreen = () => {
    const [selected, setSelected] = useState("");
    return (
        <SafeAreaView style={styles.container}>
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
            </View>
            <TouchableOpacity style={styles.button}>
                <Text style={styles.button__text}>Send</Text>
            </TouchableOpacity>
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
    }
})

export default SendScreen;