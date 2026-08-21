class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN && divisor == -1)
            return INT_MAX;

        bool negative = (dividend < 0) ^ (divisor < 0);

        long long a = dividend;
        long long b = divisor;

        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;

        long long quotient = 0;

        while (a >= b) {
            long long value = b;
            long long multiple = 1;

            while (a >= (value << 1)) {
                value <<= 1;
                multiple <<= 1;
            }

            a -= value;
            quotient += multiple;
        }

        if (negative)
            quotient = -quotient;

        if (quotient > INT_MAX)
            return INT_MAX;
        if (quotient < INT_MIN)
            return INT_MIN;

        return (int)quotient;
    }
};