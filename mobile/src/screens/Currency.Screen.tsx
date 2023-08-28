import {
    SafeAreaView,
    View,
    Text,
    StyleSheet,
    FlatList,
} from 'react-native';
import { CurrencyNode } from '../components';


const CurrencyScreen = () => {
    return (
        <SafeAreaView style={styles.container}>
            <FlatList 
                data={[]}
                renderItem={CurrencyNode}
                ItemSeparatorComponent={() => <View style={{ height: 10 }}/>}
                showsVerticalScrollIndicator={false}
                keyExtractor={({ id }) => `${id}`}
            />
        </SafeAreaView>
    )
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingHorizontal: 16,
        paddingTop: 20,
        backgroundColor: '#FFFFFF'
    },
})

export default CurrencyScreen;