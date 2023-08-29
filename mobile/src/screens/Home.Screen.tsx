import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    TouchableOpacity,
    Image,
    FlatList,
} from 'react-native';

import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useState } from 'react';

import { RootState } from '../api/store';
import { useLazyUserQuery } from '../api/service/auth.service';
import { useLazyGetAccountsQuery } from '../api/service/transaction.service';
import { TranstactionNode } from '../components';
import { updateUser } from '../api/slice/auth.slice';
 
const HomeScreen = ({ navigation: { navigate } }) => {
    const dispatch = useDispatch();
    const [accounts, setAccounts] = useState([]);

    const [getUser] = useLazyUserQuery();
    const [getAccounts] = useLazyGetAccountsQuery({});

    const user = useSelector((state: RootState) => state.authSlice);

    useEffect(() => {
        const getData = async () => {
            const { data } = await getUser({});
            const { data: accounts } = await getAccounts({});
            setAccounts(accounts)
            dispatch(updateUser({data}));
        }
        getData()
    }, [])


    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.info__container}>
                <View style={styles.balance__container}>
                    <Text style={styles.balance__text}>$32.01</Text>
                </View>
                <View style={styles.line}></View>
                <View style={styles.actions__container}>
                    <TouchableOpacity style={styles.action__wrapper} onPress={() => navigate('Send', {})}>
                        <Image
                            source={require('../assets/send.png')}
                        />
                        <Text style={styles.action__text}>Send</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.action__wrapper} onPress={() => navigate('Receive', {})}>
                        <Image
                            source={require('../assets/receive.png')}
                        />
                        <Text style={styles.action__text}>Receive</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.action__wrapper} onPress={() => navigate('Buy', {})}>
                        <Image
                            source={require('../assets/buy.png')}
                        />
                        <Text style={styles.action__text}>Buy</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.action__wrapper} onPress={() => navigate('Swap', {})}>
                        <Image
                            source={require('../assets/swap.png')}
                        />
                        <Text style={styles.action__text}>Swap</Text>
                    </TouchableOpacity>
                </View>
            </View>
            <TouchableOpacity style={styles.button} onPress={() => navigate('Account')}>
                <Text style={styles.button__text}>Create Account</Text>
            </TouchableOpacity>
            <FlatList
                data={[
                    { account: '№423493240243', date: '28.08.2023', amount: '9345,35 RUB' },
                    { account: '№334497540212', date: '10.12.2022', amount: '9435,35 RUB' },
                    { account: '№434593234264', date: '05.01.2022', amount: '12345,35 EU' },
                    { account: '№423493240243', date: '28.08.2023', amount: '9345,35 RUB' },
                    { account: '№334497540212', date: '10.12.2022', amount: '9435,35 RUB' },
                    { account: '№434593234264', date: '05.01.2022', amount: '12345,35 EU' },
                    { account: '№423493240243', date: '28.08.2023', amount: '9345,35 RUB' },
                    { account: '№334497540212', date: '10.12.2022', amount: '9435,35 RUB' },
                    { account: '№434593234264', date: '05.01.2022', amount: '12345,35 EU' },
                    { account: '№423493240243', date: '28.08.2023', amount: '9345,35 RUB' },
                    { account: '№334497540212', date: '10.12.2022', amount: '9435,35 RUB' },
                    { account: '№434593234264', date: '05.01.2022', amount: '12345,35 EU' }
                ]}
                renderItem={TranstactionNode}
            />
        </SafeAreaView>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#FFFFFF'
    },
    info__container: {
        width: '100%',
        backgroundColor: '#5DB097',
        alignItems: 'center',
        paddingHorizontal: 16,
    },
    link__container: {
        flex: 1,
    },
    line: {
        width: '60%',
        height: 3,
        backgroundColor: '#fff',
        marginVertical: 30,
        borderRadius: 5,
    },
    balance__container: {
        marginTop: 60,
    },
    balance__text: {
        color:'#fff',
        fontSize: 30,
    },
    actions__container: {
        display: 'flex',
        gap: 16,
        flexDirection: 'row',
        paddingBottom: 25,
    },
    action__wrapper: {
        width: 74,
        height: 90,
        borderRadius: 10,
        paddingTop: 10,
        paddingBottom: 10,
        justifyContent: 'space-between',
        elevation: 10,
        backgroundColor: '#fff'
    },
    action__text: {
        textAlign: 'center',
        fontSize: 14,
        color: '#4B947E'
    },
    button: {
        width: '80%',
        paddingVertical: 16,
        borderRadius: 100,
        backgroundColor: '#5DB097',
        marginVertical: 15,
        alignSelf: 'center',
    },
    button__text: {
        color: '#fff',
        fontSize: 16,
        fontWeight: '600',
        textAlign: 'center'
    },
    
})

export default HomeScreen;