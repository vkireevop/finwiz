import { FC } from 'react';

import {
    TextInput,
    StyleSheet,
    TextInputProps,
} from 'react-native';

const Input: FC<TextInputProps> = ({
    ...rest
}) => {
    return (
        <TextInput
            style={styles.input__container}
            {...rest}
        />
    )
};

const styles = StyleSheet.create({
    input__container: {
        width: '100%',
        height: 50,
        backgroundColor: '#F6F6F6',
        borderWidth: 1,
        borderColor: '#E8E8E8',
        borderRadius: 8,
        paddingLeft: 16,
    }
})

export default Input;