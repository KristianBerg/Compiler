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
gcd1:
        pushq %rbp
        movq %rsp, %rbp
        subq $0, %rsp
//while
While_2_start:
        movq 24(%rbp), %rax
        pushq %rax
        movq 16(%rbp), %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovne %rdx, %rax
        cmpq $0, %rax
        je While_3_end
        movq 24(%rbp), %rax
        pushq %rax
        movq 16(%rbp), %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmovg %rdx, %rax
//if
        cmpq $1, %rax
        jne If_4_end
        movq 24(%rbp), %rax
        pushq %rax
        movq 16(%rbp), %rax
        popq %rbx
        subq %rbx, %rax
        movq %rax, 16(%rbp)
        jmp Else_5_end
If_4_end:
        movq 16(%rbp), %rax
        pushq %rax
        movq 24(%rbp), %rax
        popq %rbx
        subq %rbx, %rax
        movq %rax, 24(%rbp)
Else_5_end:
        jmp While_2_start
While_3_end:
        //return
        movq 16(%rbp), %rax
        movq %rbp, %rsp
        popq %rbp
        ret
        //default return
        movq $0, %rax
        movq %rbp, %rsp
        popq %rbp
        ret
gcd2:
        pushq %rbp
        movq %rsp, %rbp
        subq $0, %rsp
        movq $0, %rax
        pushq %rax
        movq 24(%rbp), %rax
        popq %rbx
        movq %rax, %rcx
        movq $0, %rax
        movq $1, %rdx
        cmpq %rbx, %rcx
        cmove %rdx, %rax
//if
        cmpq $1, %rax
        jne If_6_end
        //return
        movq 16(%rbp), %rax
        movq %rbp, %rsp
        popq %rbp
        ret
If_6_end:
        //return
        movq 24(%rbp), %rax
        pushq %rax
        movq 16(%rbp), %rax
        popq %rbx
        movq $0, %rdx
        idivq %rbx, %rax
        movq %rdx, %rax
        pushq %rax
        movq 24(%rbp), %rax
        pushq %rax
        call gcd2
        addq $16, %rsp
        movq %rbp, %rsp
        popq %rbp
        ret
        //default return
        movq $0, %rax
        movq %rbp, %rsp
        popq %rbp
        ret
main:
        pushq %rbp
        movq %rsp, %rbp
        subq $24, %rsp
        call read
        addq $0, %rsp
        movq %rax, -8(%rbp)
        call read
        addq $0, %rsp
        movq %rax, -16(%rbp)
        movq -16(%rbp), %rax
        pushq %rax
        movq -8(%rbp), %rax
        pushq %rax
        call gcd1
        addq $16, %rsp
        pushq %rax
        call print
        addq $8, %rsp
        movq -16(%rbp), %rax
        pushq %rax
        movq -8(%rbp), %rax
        pushq %rax
        call gcd2
        addq $16, %rsp
        pushq %rax
        call print
        addq $8, %rsp
        movq -16(%rbp), %rax
        pushq %rax
        movq -8(%rbp), %rax
        pushq %rax
        call gcd2
        addq $16, %rsp
        pushq %rax
        movq -16(%rbp), %rax
        pushq %rax
        movq -8(%rbp), %rax
        pushq %rax
        call gcd1
        addq $16, %rsp
        popq %rbx
        subq %rbx, %rax
        movq %rax, -24(%rbp)
        movq -24(%rbp), %rax
        pushq %rax
        call print
        addq $8, %rsp
        //return
        movq $0, %rax
        movq %rbp, %rsp
        popq %rbp
        ret
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
