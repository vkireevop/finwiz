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

const SwapScreen = () => {
    const [selected, setSelected] = useState("");
    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.form}>
                <SelectList 
                    setSelected={(val) => setSelected(val)} 
                    data={[]}
                    placeholder='Sender Account'
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
                <SelectList 
                    setSelected={(val) => setSelected(val)} 
                    data={[]}
                    placeholder='Recipient Account'
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
                <Input 
                    placeholder='Amount'
                    keyboardType='numeric'
                />
            </View>
            <TouchableOpacity style={styles.button}>
                <Text style={styles.button__text}>Swap</Text>
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
})

export default SwapScreen;