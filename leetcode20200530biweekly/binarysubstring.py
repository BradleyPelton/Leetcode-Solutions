
# Very frustating. Spent 20 minutes debugging the bug "using length k instead of length(bin(k))"
# After finished debugging, my solution Time limited exceeded

# If k=15, there are 32768 binary strings of length k. Checking if all 32768 are in string s
# is obviously not a good idea. I'm sure there is some clever trick with binary numbers here
# that I am missing. Fucking frustrating
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        """ """
        def generate_all_binary(total_len, all_bins):
            """ """
            zero_append = ['0' + binstr for binstr in all_bins]
            one_append = ['1' + binstr for binstr in all_bins]

            all_bins = zero_append + one_append
            # print(all_bins)

            # print(len(all_bins[0]))
            if len(all_bins[0]) == total_len:
                # print("attempting to stop")
                global finish_bins
                finish_bins = all_bins
                # return all_bins
            else:
                generate_all_binary(total_len, all_bins)


        if k == 1:
            all_k_bins = ['0', '1']
        elif k == 2:
            all_k_bins = ['00', '01', '10', '11']
        else:
            generate_all_binary(k, ['0', '1'])
            all_k_bins = finish_bins
        # print(f"all binaries of length {k} are ")
        # print(all_k_bins)

        for binstr in all_k_bins:
            if binstr not in s:
                print(f"found a binstr {binstr} not in {s}")
                return False
        print("passed")
        return True


a = Solution()
# a.hasAllCodes('00110110', 2)
# a.hasAllCodes('00110', 2)
# a.hasAllCodes('0110', 1)
# a.hasAllCodes('0110', 2)
a.hasAllCodes('0000000001011100', 4)
