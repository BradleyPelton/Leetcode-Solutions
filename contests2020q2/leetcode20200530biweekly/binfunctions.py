def generate_all_binary(total_len, all_bins):
    """ """
    zero_append = ['0' + binstr for binstr in all_bins]
    one_append = ['1' + binstr for binstr in all_bins]

    all_bins = zero_append + one_append
    # print(all_bins)

    # print(len(all_bins[0]))
    if len(all_bins[0]) == total_len:
        print("attempting to stop")
        global finish_bins
        finish_bins = all_bins
        # return all_bins
    else:
        generate_all_binary(total_len, all_bins)



generate_all_binary(15, ['0','1'])
print(len(finish_bins))
