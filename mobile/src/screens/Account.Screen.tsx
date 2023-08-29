import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
} from 'react-native';

import { RootState } from '../api/store';
import { useBanksQuery } from '../api/service/transaction.service';
import { useCreateAccountMutation } from '../api/service/transaction.service';

import { SelectList } from 'react-native-dropdown-select-list'

const AccountScreen = ({ navigation }) => {

    const [create] = useCreateAccountMutation();
    const { user } = useSelector((state: RootState) => state.authSlice);

    const [selectedBank, setSelectedBank] = useState("");
    const [selectedCurrency, setSelectedCurrency] = useState("");

    const [banksSelect, setBanks] = useState([]);

    const { data: banks } = useBanksQuery({});
    
    useEffect(() => {
        const data = []
        if (banks) {
            for (let item of banks) {
                data.push({ key: item.name, value: item.bankId })
            }
            setBanks(data);
        }
    }, [banks])

    const handleCreateAccount = async () => {
        const { id, username } = user;
        if (selectedBank && selectedCurrency) {
            await create({
                user: id,
                bank: selectedBank,
                currency: selectedCurrency,
                balance: '0',
            })
            navigation.navigate('Main')
        }
    };

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.form}>
                <SelectList 
                    setSelected={(val) => setSelectedBank(val)} 
                    data={banksSelect}
                    placeholder='Select Bank'
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
                <SelectList 
                    setSelected={(val) => setSelectedCurrency(val)} 
                    data={[
                        { value: 'BRL' },
                        { value: 'RUB' },
                        { value: 'CNY' },
                        { value: 'INR' },
                        { value: 'KGS' },
                        { value: 'KZT' },
                        { value: 'TJS' },
                        { value: 'UZS' },
                        { value: 'ZAR' },
                    ]}
                    placeholder='Select Currency'
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
                <TouchableOpacity style={styles.button} onPress={() => handleCreateAccount()}>
                    <Text style={styles.button__text}>Create Account</Text>
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
})

export default AccountScreen;