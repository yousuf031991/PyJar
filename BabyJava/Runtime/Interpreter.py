
# coding: utf-8

# ## Basic mockup for a factorial program

# ##### High level code
# ```x = read
# i = x
# fact = 1
# while (i > 1){
#    fact = fact * i
#    i = i - 1
# }
# print fact
# ```

# ##### Low level code
# ```
# read
# store x
# push x
# store i
# push   1
# store fact
# push i
# push   1
# greater
# testfgoto 20
# push fact
# push i
# multiply
# store fact
# push i
# push   1
# minus
# store i
# push True
# testtgoto 6
# push fact
# print
# end
# ```

# ##### Intermediate code operation definitions
# * **READ** - gets input from user and pushes on to the stack
# * **STORE varname** - pops a value from the stack and store it in variable varname
# * **PUSH varname** - pushes variable varname on to the stack
# * **TESTFGOTO line_no** - pops from stack, if popped value is False, sends execution to line_no
# * **TESTTGOTO line_no** - pops from stack, if popped value is True, sends execution to line_no
# * **PRINT** - pops from stack and prints on to the console
# * **DIVIDE, MULTIPLY, ADD, SUBTRACT** - pop from the stack twice, perform the operation on the 2 popped values
# * **GREATER, LESSER, EQUAL, GREATEREQUAL, LESSEREQUAL** - pop from the stack twice, perform the operation on the 2 popped values, _and push the result on to the stack_
# * **NOP** - do nothing
# 

# In[17]:

class Runtime:
    def __init__(self, isfunc = False):
        self.sym_table = []
        self.sym_dict = {}
        self.call_stack = []
        
class Interpreter:
    def __init__(self, program = [], debug = False):
        self.ip = 0
        self.ep = 0  
        self.program = program
        self.run_stack = []
        glob_runtime = Runtime()
        self.run_stack.append(glob_runtime)
        self.next_is_func = False
        self.debug = debug
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
        val_types = [int, bool, float]
        if type(args) in val_types:
            return args
        ele = args[0]
        if self.debug:
            print ele, type(ele)        
        try:
            ele = self.run_stack[0].sym_dict[ele]
            return ele                        
        except Exception:
            pass
        try:
            ele = int(ele)
            return ele
        except Exception:
            pass
        try:
            ele = float(ele)
            return ele
        except Exception:
            pass
        try:
            ele = bool(ele)
            return ele
        except Exception:
            pass
        if self.debug:
            print '{} - {}'.format(ele, "Not found in the dictionary")
        
    def RUN(self):
        while self.ip < len(self.program):
            self.step()
    
    def READ(self, args):
        par = raw_input()
        self.run_stack[0].sym_table.append(par)
    
    def NOP(self, args):
        pass
    
    def RET(self, args):
        self.ip = self.call_stack.pop()
        self.run_stack.pop()
        self.run_stack[0].sym_table.append(args)        
    
    def OPENBLOCK(self, args):
        if self.next_is_func is True:
            runtime = Runtime(True)            
        else:
            runtime = Runtime()    
        self.run_stack.append(runtime)
        self.next_is_func = False
        
    def CLOSEBLOCK(self, args):
        self.run_stack.pop()
        
    def CALL(self, args):
        self.next_is_func = True        
        self.call_stack.append(self.ip + 1)
        self.ip = args
    
    def PRINT(self, args):
        par = self.run_stack[0].sym_table.pop()
        op = self.find_in_dict(par)
        print op
    
    def PUSH(self, args):
        self.run_stack[0].sym_table.append(args)
    
    def STORE(self, args):        
        par = self.run_stack[0].sym_table.pop()
        par = self.find_in_dict(par)
        self.run_stack[0].sym_dict[args[0]] = par
    
    def ADD(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op1 + op2)
        
    def SUBTRACT(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 - op1)
    
    def MULTIPLY(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)        
        self.run_stack[0].sym_table.append(op1 * op2)       
    
    def DIVIDE(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 / op1)
    
    def GREATER(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()        
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 > op1)
    
    def LESSER(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 < op1)
        
    def GREATEREQUAL(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 >= op1)
        
    def LESSEREQUAL(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 <= op1)
        
    def EQUALS(self, args):
        par1 = self.run_stack[0].sym_table.pop()
        par2 = self.run_stack[0].sym_table.pop()
        op1 = self.find_in_dict(par1)
        op2 = self.find_in_dict(par2)
        self.run_stack[0].sym_table.append(op2 == op1)
    
    def TESTTGOTO(self, args):
        par = self.run_stack[0].sym_table.pop()
        par = self.find_in_dict(par)
        if par is True:
            self.ip = int(args[0])
        
    def TESTFGOTO(self, args):
        par = self.run_stack[0].sym_table.pop()
        par = self.find_in_dict(par)
        if par is False:
            self.ip = int(args[0])
        
    def END(self, args):
        pass
    
    def START(self, args):
        pass


# In[20]:

test_file = open(raw_input(), "r")
testing = test_file.read()
lines = testing.split('\n')
lines.insert(0, "START")
del lines[-1]
intp = Interpreter(lines)
intp.RUN()


# In[ ]:



