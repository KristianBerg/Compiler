.global _start
.data
ask_message: .ascii "Please enter a number: "
ask_msg_len: .quad 23
buf: .skip 1024

.text
_start:
        call main
        movq $0, %rdi
        movq $60, %rax
        syscall
main:
        pushq %rbp
        movq %rsp, %rbp
        subq $0, %rsp
        movq $2, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmove %rdx, %rax
//if
        cmpq $1, %rax
        jne If_10_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_10_end:
        movq $1, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmove %rdx, %rax
//if
        cmpq $1, %rax
        jne If_12_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_12_end:
        movq $1, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovne %rdx, %rax
//if
        cmpq $1, %rax
        jne If_14_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_14_end:
        movq $2, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovne %rdx, %rax
//if
        cmpq $1, %rax
        jne If_16_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_16_end:
        movq $2, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovge %rdx, %rax
//if
        cmpq $1, %rax
        jne If_18_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_18_end:
        movq $1, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovge %rdx, %rax
//if
        cmpq $1, %rax
        jne If_20_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_20_end:
        movq $0, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovle %rdx, %rax
//if
        cmpq $1, %rax
        jne If_22_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_22_end:
        movq $2, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovle %rdx, %rax
//if
        cmpq $1, %rax
        jne If_24_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_24_end:
        movq $1, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovl %rdx, %rax
//if
        cmpq $1, %rax
        jne If_26_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_26_end:
        movq $2, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovl %rdx, %rax
//if
        cmpq $1, %rax
        jne If_28_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_28_end:
        movq $1, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovg %rdx, %rax
//if
        cmpq $1, %rax
        jne If_30_end
        movq $1, %rax
        pushq %rax
        call print
        addq $8, %rsp
        jmp Else_31_end
If_30_end:
        movq $1337, %rax
        pushq %rax
        call print
        addq $8, %rsp
Else_31_end:
        movq $0, %rax
        pushq %rax
        movq $1, %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovg %rdx, %rax
//if
        cmpq $1, %rax
        jne If_32_end
        movq $2, %rax
        pushq %rax
        call print
        addq $8, %rsp
If_32_end:
        movq $10, %rax
        pushq %rax
        call print
        addq $8, %rsp
        //default return
        movq $0, %rax
        movq %rbp, %rsp
        popq %rbp
        ret
# Procedure to read number from stdin
# C signature: long int read(void)
read:
        pushq %rbp
        movq %rsp, %rbp
        movq $0, %rdi
        movq $buf, %rsi
        movq $1024, %rdx
        movq $0, %rax
        syscall                 # %rax = sys_read(0, buf, 1024)
        ### convert string to integer:
        ### %rax contains nchar
        ### %rsi contains ptr
        movq $0, %rdx           # sum = 0
atoi_loop:
        cmpq $0, %rax           # while (nchar > 0)
        jle atoi_done           # leave loop if nchar <= 0
        movzbq (%rsi), %rbx     # move byte, and sign extend to qword
        cmpq $0x30, %rbx        # test if < '0'
        jl atoi_done            # character is not numeric
        cmpq $0x39, %rbx        # test if > '9'
        jg atoi_done            # character is not numeric
        imulq $10, %rdx         # multiply sum by 10
        subq $0x30, %rbx        # value of character
        addq %rbx, %rdx         # add to sum
        incq %rsi               # step to next char
        decq %rax               # nchar--
        jmp atoi_loop           # loop back
atoi_done:
        movq %rdx, %rax         # return value in RAX
        popq %rbp
        ret

# Procedure to print number to stdout
# C signature: void print(long int)
print:
        pushq %rbp
        movq %rsp, %rbp
        ### convert integer to string
        movq 16(%rbp), %rax     # parameter
        movq $(buf+1023), %rsi  # write ptr (start from end of buf)
        movb $0x0a, (%rsi)      # insert newline
        movq $1, %rcx           # string length
itoa_loop:                      # do.. while (at least one iteration)
        movq $10, %rbx
        movq $0, %rdx
        idivq %rbx              # divide rdx:rax by 10
        addb $0x30, %dl         # remainder + '0'
        decq %rsi               # move string pointer
        movb %dl, (%rsi)
        incq %rcx               # increment string length
        cmpq $0, %rax
        jg itoa_loop            # produce more digits
itoa_done:
        movq $1, %rdi
        movq %rcx, %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret

print_string:
        pushq %rbp
        movq %rsp, %rbp
        movq $1, %rdi
        movq 16(%rbp), %rsi
        movq 24(%rbp), %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret
