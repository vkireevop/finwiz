import { View, Text, StyleSheet,TouchableOpacity } from 'react-native';

const TranstactionNode = ({
    item 
}) => {
    return (
        <TouchableOpacity style={styles.node__container}>
            <View style={styles.date}>
                <Text>Перевод на счет { item.account }</Text>
                <Text>от { item.date }</Text>
            </View>
            <View style={styles.money}>
                <Text>{ item.amount }</Text>
            </View>
        </TouchableOpacity>
    )
}

const styles = StyleSheet.create({
    node__container: {
        width: '100%',
        flexDirection: 'row',
        borderRadius: 10,
        justifyContent: 'space-between',
        paddingHorizontal: 16,
        paddingVertical: 15,
        alignItems: 'center',
        backgroundColor: '#fff',
        borderBottomColor: '#E8E8E8',
        borderBottomWidth: 1,
    },
    date: {
        justifyContent: 'space-between',
        flexDirection: 'column'
    },
    money: {
        alignItems: 'center'
    }
})

export default TranstactionNode;