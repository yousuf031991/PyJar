
# coding: utf-8

# ## Hardly Java Interpreter / Runtime

# ##### Intermediate code operation definitions
# * **READ** - gets input from user and pushes on to the stack
# * **STORE varname** - pops a value from the stack and store it in variable varname
# * **PUSH varname** - pushes variable varname on to the stack
# * **TESTFGOTO line_no** - pops from stack, if popped value is False, sends execution to line_no
# * **TESTTGOTO line_no** - pops from stack, if popped value is True, sends execution to line_no
# * **PRINT** - pops from stack and prints on to the console
# * **DIVIDE, MULTIPLY, ADD, SUBTRACT** - pop from the stack twice, perform the operation on the 2 popped values
# * **GREATER, LESSER, EQUALS, GREATEREQUAL, LESSEREQUAL** - pop from the stack twice, perform the operation on the 2 popped values, _and push the result on to the stack_
# * **END** - do nothing, designates program end
# 

# In[42]:

class Runtime:
    def __init__(self):
        self.sym_table = []
        self.sym_dict = {}        
        
class Interpreter:
    def __init__(self, program = [], debug = False):
        self.ip = 0
        self.ep = 0  
        self.program = program
        self.run_stack = []
        glob_runtime = Runtime()
        self.run_stack.append(glob_runtime)
        self.debug = debug
        self.f_args_dict = {}
        self.f_lno_dict = {}
        self.call_stack = []
        if self.debug:
            i = 0
            for ele in lines:
                print '{}   {}'.format(i, ele)
                i += 1
    
    def step(self):        
        line = self.program[self.ip]
        self.ip += 1
        tokens = line.split()
        opcode = tokens.pop(0)
        if self.debug:
            print  '{:03}:{} {}'.format(self.ip, opcode, tokens)       
        if hasattr(self, opcode):            
            getattr(self, opcode)(tokens)        
            
    def find_in_dict(self, args):
        val_types = [int, bool]
        if type(args) in val_types:
            return args
        if type(args) is list:
            ele = args[0]
        else:
            ele = args
        if self.debug:
            print ele, type(ele)        
        try:            
            ele = self.run_stack[self.ep].sym_dict[ele]                
            return ele                        
        except Exception:
            pass
        try:
            ele = int(ele)
            return ele
        except Exception:
            pass        
        try:
            temp_ele = bool(ele)
            if temp_ele is True:
                if ele == 'False':
                    return False
                else:
                    return True            
        except Exception:
            pass
        if self.debug:
            print '{} - {}'.format(ele, "Not found in the dictionary")
        
    def RUN(self):
        while self.ip < len(self.program):
            self.step()
    
    def READ(self, args):
        par = raw_input()
        self.run_stack[self.ep].sym_table.append(par)        
    
    def RET(self, args):                
        ret_par = self.find_in_dict(args[0])        
        self.ip = self.call_stack.pop()
        self.run_stack.pop()
        self.ep -= 1
        self.run_stack[self.ep].sym_table.append(ret_par)        
    
    def FUNC(self, args):
        arg_cnt = 0        
        self.f_lno_dict[args[0]] = self.ip
        line = self.program[self.ip]        
        tokens = line.split()        
        opcode = tokens.pop(0)
        while opcode == "STORE":
            arg_cnt += 1
            self.ip += 1
            line = self.program[self.ip]        
            tokens = line.split()
            opcode = tokens.pop(0)                    
        self.f_args_dict[args[0]] = arg_cnt
        while opcode != "ENDFUNC":
            self.ip += 1
            line = self.program[self.ip]        
            tokens = line.split()
            opcode = tokens.pop(0)
                                        
    def ENDFUNC(self, args):
        if len(self.run_stack) > 1:            
            self.run_stack.pop()
            self.ep -= 1
            self.ip = self.call_stack.pop()
        
    def CALL(self, args):
        no_pars = self.f_args_dict[args[0]]
        f_line = self.f_lno_dict[args[0]]
        self.call_stack.append(self.ip) 
        list_pars = []
        i = 0    
        while i < no_pars:
            list_pars.insert(0, self.find_in_dict(self.run_stack[self.ep].sym_table.pop())) 
            i += 1
        self.ip = f_line
        runtime = Runtime()    
        self.run_stack.append(runtime)
        self.ep += 1
        i = 0
        while i < no_pars:
            new_par = list_pars.pop()            
            line = self.program[self.ip]        
            tokens = line.split()            
            opcode = tokens.pop(0)            
            self.run_stack[self.ep].sym_dict[tokens[0]] = new_par                                     
            self.ip += 1 
            i += 1
    
    def PRINT(self, args):        
        par = self.run_stack[self.ep].sym_table.pop()
        op = self.find_in_dict(par)
        print op
    
    def PUSH(self, args):
        self.run_stack[self.ep].sym_table.append(args)
    
    def STORE(self, args):        
        par = self.run_stack[self.ep].sym_table.pop()        
        par = self.find_in_dict(par)        
        self.run_stack[self.ep].sym_dict[args[0]] = par
    
    def ADD(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)        
        self.run_stack[self.ep].sym_table.append(op1 + op2)
        
    def SUBTRACT(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 - op1)
    
    def MULTIPLY(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)        
        self.run_stack[self.ep].sym_table.append(op1 * op2)       
    
    def DIVIDE(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 / op1)
        
    def MODULUS(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 % op1)
    
    def GREATER(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()        
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 > op1)
    
    def LESSER(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 < op1)
        
    def GREATEREQUAL(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 >= op1)
        
    def LESSEREQUAL(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 <= op1)
        
    def EQUALS(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()        
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)        
        self.run_stack[self.ep].sym_table.append(op2 == op1)
        
    def AND(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 and op1)
        
    def OR(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 or op1)
        
    def IS(self, args):
        par1 = self.run_stack[self.ep].sym_table.pop()
        par2 = self.run_stack[self.ep].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[self.ep].sym_table.append(op2 == op1)
    
    def STACK(self, args):
        self.run_stack[self.ep].sym_dict[args[0]] = []

    def STACKPUSH(self, args):
        par = self.run_stack[self.ep].sym_table.pop()
        st = self.run_stack[self.ep].sym_dict[args[0]]        
        st.append(par)        
        self.run_stack[self.ep].sym_dict[args[0]] = st
        
    def STACKPOP(self, args):        
        st = self.run_stack[self.ep].sym_dict[args[0]]
        par = st.pop()        
        self.run_stack[self.ep].sym_dict[args[0]] = st
        self.run_stack[self.ep].sym_table.append(par)
        
    def STACKISEMPTY(self, args):        
        st = self.run_stack[self.ep].sym_dict[args[0]]        
        if len(st) == 0:            
            self.run_stack[self.ep].sym_table.append(True)
        else:
            self.run_stack[self.ep].sym_table.append(False)
    
    def TESTTGOTO(self, args):
        par = self.run_stack[self.ep].sym_table.pop()
        par = self.find_in_dict(par)
        if par is True:
            self.ip = int(args[0])
        
    def TESTFGOTO(self, args):
        par = self.run_stack[self.ep].sym_table.pop()
        par = self.find_in_dict(par)
        if par is False:
            self.ip = int(args[0])
        
    def END(self, args):
        pass
    
    def START(self, args):
        pass


# In[43]:

print "Enter the filename:"
test_file = open(raw_input(), "r")
testing = test_file.read()
lines = testing.split('\n')
lines.insert(0, "START")
del lines[-1]
intp = Interpreter(lines)
intp.RUN()


# In[ ]:



