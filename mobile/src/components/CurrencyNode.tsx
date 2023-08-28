import { View, Text, StyleSheet } from 'react-native';

const CurrencyNode = ({
    item 
}) => {
    return (
        <View style={styles.node__container}>
            <Text>{ item.title }</Text>
            <Text>{ item.amount }</Text>
        </View>
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
        borderColor: '#E8E8E8',
        borderWidth: 1,
    },
})

export default CurrencyNode;